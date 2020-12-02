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


function carregarCarros(cb) {

  let datas = lerDatas();
  let inicio = null;
  let fim = null;

  try {
    inicio = datas[0].toISOString();
    fim = datas[0].toISOString();
  } catch(e) {

  }

  $.ajax({
    url: servidor + "/catalogo/carrosDisponiveis",
    dataType: 'json',
    data: {
      idmarca: $("#marcas").val(),
      idmodelo: $("#modelos").val(),
      arcondicionado: $("#arcondicionado").is(":checked") ? 1 : 0,
      cambio: $("#cambio").is(":checked") ? 1 : 0,
      direcao: $("#direcao").is(":checked") ? 1 : 0,
      inicio: inicio,
      fim:fim
    }
  }).done(cb);
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
  mostrarCarros();
  return false;
}

async function mostrarCarros() {

  $("#carros div").remove();

  if (!carros || carros.length === 0) {
    const div = document.createElement("div");
    div.innerHTML = "Nenhum carro dispon&iacute;vel";
    div.className = "warning";
    $("#carros").append(div);
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

  carros.forEach((item, index) => {

    let carro = item.carro;

    let temp = document.createElement("template");
    temp.innerHTML = template.replace("{0}", index);

    const elemento = temp.content.firstChild;

    const elemento_nome = elemento.querySelector("div h4");
    elemento_nome.innerHTML = carro.marca.nome + " - " + carro.modelo.nome;

    const elemento_placa = elemento.querySelector("div small");
    elemento_placa.innerHTML = carro.placa;

    const elementos_preco = elemento.querySelectorAll("div p");
    elementos_preco[0].innerHTML = "Custo: R$ " + item.custo;
    elementos_preco[1].innerHTML = "Seguro: R$ " + item.seguro;
    elementos_preco[2].innerHTML = "Desconto: R$ " + item.descontos;
    elementos_preco[3].innerHTML = "Total: R$ " + item.total;

    let caracteristicas = [];
    if (carro.arcondicionado) caracteristicas.push("Ar Condicionado");
    if (carro.direcao) caracteristicas.push("Dire&ccedil;&atilde;o Hidr&aacute;ulica");
    if (carro.cambio) caracteristicas.push("C&acirc;mbio Autom&aacute;tico");

    const elemento_caracteristicas = elemento.querySelector("h5");
    elemento_caracteristicas.innerHTML = caracteristicas.join("; ");

    $("#carros").append(elemento);
  });
}

async function alugar(index) {

  let carro = carros[index].carro;

  var documento = prompt("Por favor, informe o número do seu documento:", "20202020");


  let datas = lerDatas();
  let inicio = null;
  let fim = null;

  try {
    inicio = datas[0].toISOString();
    fim = datas[0].toISOString();
  } catch(e) {

  }

  $.ajax({
    url: servidor + "/locacao/registrar",
    dataType: 'json',
    method: "POST",
    data: {
      placaCarro: carro.placa,
      docCliente: documento,
      inicio: inicio,
      fim: fim
    }
  }).done(function(resultado){

      console.log(resultado);

      carregarCarros((cr)=>{
        carros = cr;
        mostrarCarros();
      });

  });

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
  $("#marcas").append("<option value='0'>Todas</option>");
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
  $("#modelos").append("<option value='0'>Todos</option>");
  modelos.forEach((modelo, index) => {
    $("#modelos").append("<option value='"+modelo.id+"'>"+modelo.nome+"</option>");
  });
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

  $("#buscar").click(function(){
    carregarCarros((cr)=>{
      carros = cr;
      mostrarCarros();
    });
  })

  carregaMarcas((ms)=>{
    marcas = ms;
    mostrarMarcas();
    carregarCarros((cr)=>{
      carros = cr;
      mostrarCarros();
    });
  });


  $("#marcas").change(function(){
    carregaModelos((mds)=>{
      modelos = mds;
      mostrarModelos();
    });
  })
})
