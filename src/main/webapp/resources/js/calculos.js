 /* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function mensaje()
{
    alert(document.getElementById('form:campo').value);
    //alert('hola');
}

function imprimir()
{
    alert('kjhjk');    
}

function suma()
{
    alert('iniciando...');
    alert(document.getElementById('form:asdfInner').value);
    alert(document.getElementById('input_form:campo1').value);
    alert(document.getElementById('form:campo2').value);
    
    var resultado=parseInt(document.getElementById('input_form:campo1').value)+parseInt(document.getElementById('form:campo2').value)
    document.getElementById('form:campo3').value=resultado;
    alert(resultado);
}

function calculos()
{
    //alert('funciono');
    var mg11=document.getElementById('formValores:cmbMG11_input').value;    
    var ps11=document.getElementById('formValores:cmbPS11_input').value; 
    
        
    //var resultado=calcular(mg11,ps11);
    
    document.getElementById('formValores:idNI11').value=calcular(mg11,ps11);
    
    var mg12=document.getElementById('formValores:cmbMG12_input').value;    
    var ps12=document.getElementById('formValores:cmbPS12_input').value;    
    //var resultado=parseInt(mg12)+parseInt(ps12);    
    document.getElementById('formValores:idNI12').value=calcular(mg12,ps12);
    
    var mg13=document.getElementById('formValores:cmbMG13_input').value;    
    var ps13=document.getElementById('formValores:cmbPS13_input').value;    
    //var resultado=parseInt(mg11)+parseInt(ps13);    
    document.getElementById('formValores:idNI13').value=calcular(mg13,ps13);
    
    //alert(mg11);
    
}

function calcular(mg,ps)
{
    var mg=parseInt(mg);
    var ps=parseInt(ps);
    
    var resultado=0;
    
        if(mg>0)
        {
            if(mg>ps)
            {
                resultado=mg-ps;            
            }
            else
            {
                resultado=ps-mg;
            }
            
        }
        else
        {
            resultado=Math.abs(mg)+ps;
        }
        
        return resultado;
}
