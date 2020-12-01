function carregaMarcas(marcas) {
  $.ajax({
    url: servidor + "/catalogo/marcas",
    dataType: 'json'
  }).done(marcas);
};

function carregaModelos(modelos) {
  $.ajax({
    url: servidor + "/catalogo/modelos",
    dataType: 'json',
    data: { id: $("#marcas").val()}
  }).done(modelos);
}

async function carregarCarros(filtros) {
  let url = new URL(servidor + "/catalogo/carrosDisponiveis");

  if (filtros) {
    Object.keys(filtros)
      .forEach(key => url.searchParams.append(key, filtros[key]));
  }

  try {
    let resposta = await fetch(url);

    if (resposta.ok) {
        let conteudo = await resposta.json();

        if (!conteudo) {
          alert(
            "Requisi\u00E7\u00E3o bem-sucedida, mas corpo da resposta " +
            "n\u00E3o p\u00F4de ser interpretado"
          );
        } else {
          var lista = new Array(...conteudo);
          return lista.map(x => x);
        }
    } else {
        alert(
          "Falha ao carregar os produtos!\n",
          `Status da resposta: ${resposta.status}`,
          `Mensagem de status da resposta: ${resposta.statusText}`);
    }
  } catch (erro) {
    alert(erro);
  }

  return [];
}

async function aoEnviarFormulario(e) {
  e.preventDefault();

  const elementos = form_filtros.elements;
  filtros = {};

  const datas = lerDatas();
  if (!datas[0] || isNaN(datas[0].getTime()) ||
      !datas[1] || isNaN(datas[1].getTime())) {
    alert("Falha ao ler as datas");
    return;
  }

  filtros["inicioLocacao.dia"] = datas[0].getDate();
  filtros["inicioLocacao.mes"] = datas[0].getMonth() + 1;
  filtros["inicioLocacao.ano"] = datas[0].getFullYear();

  filtros["fimLocacao.dia"] = datas[1].getDate();
  filtros["fimLocacao.mes"] = datas[1].getMonth() + 1;
  filtros["fimLocacao.ano"] = datas[1].getFullYear();

  for (i = 0; i < elementos.length; i++) {
    const nome = elementos[i].getAttribute("name");
    const valor = elementos[i].checked;
    if (!nome) { continue; }
    filtros[nome] = valor;
  }

  carros = await this.carregarCarros(filtros);
  mostrarCarros(carros);
  return false;
}

async function mostrarCarros(carros) {
  let area_carros = document.querySelector("#carros");
  while (area_carros.firstChild) {
    area_carros.removeChild(area_carros.lastChild);
  }

  if (!carros || carros.length === 0) {
    const div = document.createElement("div");
    div.innerHTML = "Nenhum carro dispon&iacute;vel";
    div.className = "warning";
    area_carros.appendChild(div);
    return;
  }

  let template = `
      <div class="carro">
          <div>
            <h5></h5>
            <h4></h4>
            <small></small>
          </div>

          <div>
            <p></p>
            <p></p>
            <p></p>
            <p></p>
            <a onclick="alugar({0})">Alugar</a>
          </div>
      </div>
    `.trim();

  carros.forEach((carro, index) => {
    let temp = document.createElement("template");
    temp.innerHTML = template.replace("{0}", index);

    const elemento = temp.content.firstChild;

    const elemento_nome = elemento.querySelector("div h4");
    elemento_nome.innerHTML = carro.marca + " - " + carro.modelo;

    const elemento_placa = elemento.querySelector("div small");
    elemento_placa.innerHTML = carro.placa;

    const elementos_preco = elemento.querySelectorAll("div p");
    elementos_preco[0].innerHTML = "Custo: R$ " + carro.custoLocacao;
    elementos_preco[1].innerHTML = "Seguro: R$ " + carro.seguro;
    elementos_preco[2].innerHTML = "Desconto: R$ " + carro.desconto;
    elementos_preco[3].innerHTML = "Total: R$ " + carro.totalPagar;

    let caracteristicas = [];
    if (carro.arcondicionado) caracteristicas.push("Ar Condicionado");
    if (carro.direcao) caracteristicas.push("Dire&ccedil;&atilde;o Hidr&aacute;ulica");
    if (carro.cambio) caracteristicas.push("C&acirc;mbio Autom&aacute;tico");

    const elemento_caracteristicas = elemento.querySelector("h5");
    elemento_caracteristicas.innerHTML = caracteristicas.join("; ");

    area_carros.appendChild(elemento);
  });
}

async function alugar(index) {
  let url = new URL(servidor + "/locadora/confirmaLocacao");
  const carro = carros[index];

  try {
    let resposta = await fetch(url, {
      method: "POST",
      body: JSON.stringify(carro),
      headers: { "Content-type": "application/json;charset=UTF8" }
    });

    if (resposta.ok) {
        let conteudo = await resposta.json();

        if (!conteudo) {
          alert(
            "Requisi\u00E7\u00E3o bem-sucedida, mas corpo da resposta " +
            "n\u00E3o p\u00F4de ser interpretado"
          );
        } else {
          alert("Loca\u00e7\u00e3o conclu\u00edda com sucesso");
          carros = await carregarCarros(filtros);
          mostrarCarros(carros);
        }
    } else {
        alert(
          "Falha ao confirmar a loca&ccedil;&atilde;o!\n",
          `Status da resposta: ${resposta.status}`,
          `Mensagem de status da resposta: ${resposta.statusText}`);
    }
  } catch (erro) {
    alert(erro);
  }
}

function lerDatas() {
  const inputs_inicio = document.querySelectorAll("#inicioLocacao input");
  const inicio_dia = parseInt(inputs_inicio[0].value);
  const inicio_mes = parseInt(inputs_inicio[1].value);
  const inicio_ano = parseInt(inputs_inicio[2].value);
  const inicio = new Date(inicio_ano, inicio_mes - 1, inicio_dia);

  const inputs_fim = document.querySelectorAll("#fimLocacao input");
  const fim_dia = parseInt(inputs_fim[0].value);
  const fim_mes = parseInt(inputs_fim[1].value);
  const fim_ano = parseInt(inputs_fim[2].value);
  const fim = new Date(fim_ano, fim_mes - 1, fim_dia);

  return [inicio, fim];
}

let filtros = {};
let carros = [];
let marcas = [];
let modelos = [];

function mostrarMarcas(cb) {
  if(marcas.length == 0) {
    return;
  }
  $("#marcas option").remove();
  $("#marcas").append("<option id=''>Todas</option>");
  marcas.forEach((marca, index) => {
    $("#marcas").append("<option value='"+marca.id+"'>"+marca.nome+"</option>");
  });
  if(cb) {
    cb();
  }
}

function mostrarModelos(cb) {
  if(modelos.length == 0) {
    return;
  }
  $("#modelos option").remove();
  $("#modelos").append("<option id=''>Todos</option>");
  for(let modelo of modelos) {
    $("#modelos").append("<option value='"+modelo.id+"'>"+modelo.nome+"</option>");
  }
  if(cb) {
    cb();
  }
}

$(document).ready(function() {
  // Testa se o servidor foi definido
  if (!servidor) {
    console.warn("Voc\u00EA precisa definir o endere\u00E7o do seu servidor no arquivo \'index.html\'");
    return;
  }

  // Adiciona tratamento para o envio do formulário
  let form_filtros = document.getElementById("form_filtros");
  form_filtros.onsubmit = aoEnviarFormulario.bind(this);

  carregaMarcas((ms)=>{
    marcas = ms;
    mostrarMarcas();
  });


  $("#marcas").change(function(){
    carregaModelos((mds)=>{
      modelos = mds;
      mostrarModelos();
    });
  })
})
