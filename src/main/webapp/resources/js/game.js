//window.addEventListener('load', init, false);
var canvas = null, ctx = null;

function init() {
    canvas = document.getElementById('canvas');
    canvas.style.background = 'rgb(169,165,196)';
    ctx = canvas.getContext('2d');
    alto = ctx.canvas.height;
    ancho = ctx.canvas.width;
    paint(ctx, ancho / 2, 0, 0, alto, ancho, alto, 8);

}

window.onload = function ()
{
    //alert('todo muy bien');
    //document.getElementById('campo1').onclick();
    //document.getElementById('campo2').onclick();
    document.getElementById('campo3').onclick();
    document.getElementById('campo3').blur();

    document.getElementById('campo4').onclick();
    document.getElementById('campo4').blur();

    document.getElementById('campo5').onclick();
    document.getElementById('campo6').onclick();
    document.getElementById('campo7').onclick();
    document.getElementById('campo8').onclick();
    document.getElementById('campo9').onclick();
    document.getElementById('campo10').onclick();
    document.getElementById('campo11').onclick();
    document.getElementById('campo12').onclick();
    document.getElementById('campo13').onclick();
    document.getElementById('campo14').onclick();
    document.getElementById('campo15').onclick();
    document.getElementById('campo16').onclick();
    document.getElementById('campo17').onclick();
    document.getElementById('campo18').onclick();
    document.getElementById('campo19').onclick();
    document.getElementById('campo20').onclick();
    document.getElementById('campo21').onclick();
    document.getElementById('campo22').onclick();
    document.getElementById('campo23').onclick();
    document.getElementById('campo24').onclick();
    document.getElementById('campo25').onclick();
    document.getElementById('campo26').onclick();
    document.getElementById('campo27').onclick();
    document.getElementById('campo28').onclick();
    document.getElementById('campo29').onclick();
    document.getElementById('campo30').onclick();
    document.getElementById('campo31').onclick();
    document.getElementById('campo32').onclick();
    document.getElementById('campo33').onclick();
    document.getElementById('campo34').onclick();
    document.getElementById('campo35').onclick();
    document.getElementById('campo36').onclick();
    document.getElementById('campo37').onclick();
    document.getElementById('campo38').onclick();
    document.getElementById('campo39').onclick();
    document.getElementById('campo40').onclick();
    document.getElementById('campo41').onclick();
    document.getElementById('campo42').onclick();
    document.getElementById('campo43').onclick();
    document.getElementById('campo44').onclick();
    document.getElementById('campo45').onclick();
    document.getElementById('campo46').onclick();
    document.getElementById('campo47').onclick();
    document.getElementById('campo48').onclick();
    document.getElementById('campo49').onclick();
    document.getElementById('campo50').onclick();
    document.getElementById('campo51').onclick();
    document.getElementById('campo52').onclick();
    document.getElementById('campo53').onclick();
    document.getElementById('campo54').onclick();
    document.getElementById('campo55').onclick();
    document.getElementById('campo56').onclick();
    document.getElementById('campo57').onclick();
    document.getElementById('campo58').onclick();
    document.getElementById('campo59').onclick();
    document.getElementById('campo60').onclick();
    document.getElementById('campo61').onclick();
    document.getElementById('campo62').onclick();
    document.getElementById('campo63').onclick();
    document.getElementById('campo64').onclick();
    document.getElementById('campo65').onclick();
    document.getElementById('campo66').onclick();
    //document.getElementById('hidden:link').onclick();
}

function paint(ctx, x1, y1, x2, y2, x3, y3, it) {

    //dibujar el triangulo
    if (it % 2 != 0)
        ctx.fillStyle = 'rgb(0,0,200)';
    else
        ctx.fillStyle = 'rgb(0,0,0)';

    ctx.beginPath();
    ctx.moveTo(x1, y1);
    ctx.lineTo(x2, y2);
    ctx.lineTo(x3, y3);
    ctx.lineTo(x1, y1);
    ctx.stroke();
    ctx.fill();

    it--;
    if (it > 0)
    {
        paint(ctx, x1, y1, (x1 + x2) / 2, (y1 + y2) / 2, (x1 + x3) / 2, (y1 + y3) / 2, it);
        paint(ctx, (x1 + x2) / 2, (y1 + y2) / 2, x2, y2, (x2 + x3) / 2, (y2 + y3) / 2, it);
        paint(ctx, (x1 + x3) / 2, (y1 + y3) / 2, (x2 + x3) / 2, (y2 + y3) / 2, x3, y3, it);

    }


}

function dibujarDiente(canvas, path, orientacion, mg1, mg2, mg3, ps1, ps2, ps3, lmg)
{
    mg1 = parseInt(mg1);
    mg2 = parseInt(mg2);
    mg3 = parseInt(mg3);

    ps1 = parseInt(ps1);
    ps2 = parseInt(ps2);
    
    ps3 = parseInt(ps3);
    
    
    var psAux1=ps1;
    var psAux2=ps2;
    var psAux3=ps3;
    
    var nl1;
    var nl2;
    var nl3;

    if (mg1 >= 0)
        if (mg1 > ps1)
            nl1 = mg1 - ps1;
        else
            nl1 = ps1 - mg1;
    else
        nl1 = Math.abs(mg1) + Math.abs(ps1);

    //alert(mg1 +" -"+ps1+"-"+nl1)
    //alert(nl1);

    ////////////////segundos valores/////////////
    if (mg2 >= 0)
        if (mg2 > ps2)
            nl2 = mg2 - ps2;
        else
            nl2 = ps2 - mg2;
    else
        nl2 = Math.abs(mg2) + Math.abs(ps2);

    /////////////terceros valores////////////////
    if (mg3 >= 0)
        if (mg3 > ps3)
            nl3 = mg3 - ps3;

        else
            nl3 = ps3 - mg3;
    else
        nl3 = Math.abs(mg3) + Math.abs(ps3);




    orientacion = parseInt(orientacion);
   
    mg1 = parseInt(mg1) * orientacion;
    mg2 = parseInt(mg2) * orientacion;
    mg3 = parseInt(mg3) * orientacion;

    ps1 = parseInt(ps1) * orientacion;
    ps2 = parseInt(ps2) * orientacion;
    ps3 = parseInt(ps3) * orientacion;

    canvas = document.getElementById(canvas);
    canvas.style.background = 'rgb(169,165,196)';

    ctx = canvas.getContext('2d');

    ancho = ctx.canvas.width;
    alto = ctx.canvas.height;
    
    //////////////////Dibujar MG////////////////////////
    dibujarImg(path, ctx, ancho, alto,orientacion,mg1,mg2,mg3,ps1,ps2,ps3,lmg,psAux1,psAux2,psAux3,nl1,nl2,nl3);
    //dibujarCuadricula(ctx, ancho, alto);
    //dibujarLineaBase(ctx, ancho, alto, orientacion);


//    //////////////Dibujar PS//////////////////////////////
    //dibujarFuncion(ctx, ancho, alto, orientacion, mg1, mg2, mg3, '4');
    //dibujarFuncion(ctx, ancho, alto, orientacion, mg1 - ps1, mg2 - ps2, mg3 - ps3, '2');
    //dibujarFuncion(ctx, ancho, alto, orientacion, lmg, lmg, lmg, '1');
    
    //dibujarLineaLMG(ctx, ancho, alto, orientacion,1.5);


    ////////////////Dibujar linea vertical /////////////////

//    if (psAux1 >= 4)
//    {
//        dibujarIntermedio(ctx, ancho, alto,orientacion, 1, mg1, mg1 - ps1, '3');
//    }
//
//    if (psAux2 >= 4)
//    {
//        dibujarIntermedio(ctx, ancho, alto,orientacion, 2, mg2, mg2 - ps2, '3');
//    }
//    //alert(psAux3);
//    if (psAux3 >= 4)
//    {
//        dibujarIntermedio(ctx, ancho, alto,orientacion, 3, mg3, mg3 - ps3, '3');
//    }

    //dibujarFuncion(ctx,ancho,alto,3,10,0,'2');
    //dibujarIntermedio(ctx,ancho,alto,3,10,'3');


}

function dibujarIntermedio(ctx, ancho, alto,orientacion, distancia, y1, y2, color)
{
    y1 = -y1;
    y2 = -y2;

    incremento = alto / 25;
   // base = alto * 16 / 25;
    
    if (orientacion == -1)
        base = alto * 16 / 25;
    else
        base = alto * 10 / 25;

    //verde
    if (color == '1')
    {
        ctx.strokeStyle = "rgb(0,255,0)";
    }

    //azul
    if (color == '2')
    {
        ctx.strokeStyle = "rgb(0,0,255)";
    }

    //negro
    if (color == '3')
    {
        ctx.strokeStyle = "rgb(0,0,0)";
    }

    //rojo
    if (color == '4')
    {
        ctx.strokeStyle = "rgb(255,0,0)";
    }

    ctx.beginPath();

    //ctx.strokeStyle = "rgb(255,0,0)";
    if (distancia == 1)
    {
        ctx.moveTo(ancho * 1 / 5, base + y1 * incremento);
        ctx.lineTo(ancho * 1 / 5, base + y2 * incremento);
    }

    if (distancia == 2)
    {
        ctx.moveTo(ancho * 2.5 / 5, base + y1 * incremento);
        ctx.lineTo(ancho * 2.5 / 5, base + y2 * incremento);
    }

    if (distancia == 3)
    {
        ctx.moveTo(ancho * 4 / 5, base + y1 * incremento);
        ctx.lineTo(ancho * 4 / 5, base + y2 * incremento);
    }


    ctx.stroke();


}

function dibujarLineaLMG(ctx, ancho, alto, orientacion,lmg)
{
    incremento = alto / 25;

    if (orientacion == -1)
        alto = 16;
    else
        alto = 10;

    limite1 = ancho * 1 / 5;
    limite2 = ancho * 4 / 5;
    ctx.beginPath();

    ctx.strokeStyle = "rgb(255,0,0)";

    ctx.moveTo(limite1, alto * incremento*lmg);
    ctx.lineTo(limite2, alto * incremento*lmg);
    ctx.stroke();
    
}

function dibujarLineaBase(ctx, ancho, alto, orientacion)
{

    incremento = alto / 25;

    if (orientacion == -1)
        alto = 16;
    else
        alto = 10;

    limite1 = ancho * 1 / 5;
    limite2 = ancho * 4 / 5;
    ctx.beginPath();
    
    ctx.strokeStyle = "rgb(0,0,0)";

    ctx.moveTo(limite1, alto * incremento);
    ctx.lineTo(limite2, alto * incremento);
    ctx.stroke();

}

function dibujarFuncion(ctx, ancho, alto, orientacion, y1, y2, y3, color)
{

    incremento = alto / 25;


    if (orientacion == -1)
        base = alto * 16 / 25;
    else
        base = alto * 10 / 25;

    y1 = -y1;
    y2 = -y2;
    y3 = -y3;

    ctx.beginPath();

    if (color == '1')
    {
        ctx.strokeStyle = "rgb(53,142,0)";
    }

    if (color == '2')
    {
        ctx.strokeStyle = "rgb(0,0,255)";
    }

    if (color == '3')
    {
        ctx.strokeStyle = "rgb(0,255,255)";
    }

    //rojo
    if (color == '4')
    {
        ctx.strokeStyle = "rgb(255,0,0)";
    }

    ctx.moveTo(ancho * 1 / 5, base + y1 * incremento);
    ctx.lineTo(ancho * 2.5 / 5, base + y2 * incremento);
    ctx.lineTo(ancho * 4 / 5, base + y3 * incremento);
    ctx.stroke();
}

function alerta(msj)
{
    alert(msj);
}


function dibujarImg(path, ctx, ancho, alto,orientacion,mg1,mg2,mg3,ps1,ps2,ps3,lmg,psAux1,psAux2,psAux3,nl1,nl2,nl3)
{
    //alert("orientacion"+orientacion);
//    alert("mg1="+mg1);
//    alert("mg2="+mg2);
//    alert("mg3="+mg3);
//    alert("ps1="+ps1);
//    alert("ps2="+ps2);
//    alert("ps3="+ps3);
//    alert("lmg="+lmg);
//    alert("psAux1="+psAux1);
//    alert("psAux2="+psAux2);
//    alert("psAux3="+psAux3);
    var img = new Image();
    //alert(path);
    img.src = path;
    img.onload = function(){
        ctx.drawImage(img, 0, 0, ancho, alto);
            
        
        if(mg1==0 && mg2==0 && mg3==0 & ps1==0 && ps2==0 && ps3==0)
        {
            ctx.strokeStyle = "rgb(53,142,0)";
            ctx.moveTo(0,0);
            ctx.lineTo(ancho,alto);
            
            ctx.moveTo(ancho,0);
            ctx.lineTo(0,alto);
            //ctx.lineTo(alto,0);
            //ctx.lineTo(ancho * 4 / 5, base + y3 * incremento);
            ctx.stroke();
        }
        else
        {
            
            dibujarCuadricula(ctx, ancho, alto); 
            dibujarLineaBase(ctx, ancho, alto, orientacion);

            dibujarFuncion(ctx, ancho, alto, orientacion, mg1, mg2, mg3, '4');
            dibujarFuncion(ctx, ancho, alto, orientacion, mg1 - ps1, mg2 - ps2, mg3 - ps3, '2');
            dibujarFuncion(ctx, ancho, alto, orientacion, lmg, lmg, lmg, '1');

            if (nl1 >= 4)
            {
                dibujarIntermedio(ctx, ancho, alto,orientacion, 1, mg1, mg1 - ps1, '3');
            }

            if (nl2 >= 4)
            {
                dibujarIntermedio(ctx, ancho, alto,orientacion, 2, mg2, mg2 - ps2, '3');
            }
            //alert(psAux3);
            if (nl3 >= 4)
            {
                dibujarIntermedio(ctx, ancho, alto,orientacion, 3, mg3, mg3 - ps3, '3');
            }
            
        }
       
        
    }
}

function dibujarCuadricula(ctx, ancho, alto)
{
    incremento = alto / 25;
    //alert(incremento);
    ctx.strokeStyle = "rgba(0,0,0,0.05)";
    //ctx.fillRect (0, 0, 20, 20);

    for (i = 0; i < 25; i++)
    {
        ctx.beginPath();

        ctx.moveTo(0, i * incremento);
        ctx.lineTo(ancho, i * incremento);
        ctx.stroke();
    }

}

function imprimir()
{
    alert('ok');
}

function dibujar()
{

    canvas = document.getElementById('canvas2');
    canvas.style.background = 'rgb(169,165,196)';
    ctx = canvas.getContext('2d');


//    x1=0;
//    x2=100;
//    y1=100;
//    y2=100;
//    
//    
//    ctx.beginPath();
//    ctx.moveTo(x1, y1);
//    ctx.lineTo(x2, y2);    
    //ctx.stroke();
    //ctx.fill();

}