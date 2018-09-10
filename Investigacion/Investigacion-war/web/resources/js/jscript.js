/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function AbrirSeguro(path)
{
    var cadena;
    var ancho = screen.availWidth - 10;
    var alto = screen.availHeight - 70;
    cadena = 'left=0,top=0,border=0,status=no,scrollbars=yes,toolbar=no,menubar=no,location=yes,resizable=yes,directories=no,width=' + ancho + ',height=' + alto;
    window.open("https://www.espe.edu.ec/", "Registro Datos", cadena);
}


function crea_formOpenWindow(url,params) {
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", url);
    // setting form target to a window named 'formresult'
    form.setAttribute("target", "formresult");
    if (params!=''){
        for (var i in params) {
            if (params.hasOwnProperty(i)) {
                var input = document.createElement('input');
                input.type = 'hidden';
                input.name = i;
                input.value = params[i];
                form.appendChild(input);
            }
        }
    }
    document.body.appendChild(form);
    // creating the 'formresult' window with custom features prior to submitting the form
    var w = window.open(url, 'formresult', 'scrollbars=no,menubar=no,height=550,width=600,resizable=yes,toolbar=no,status=no');
    w.focus();
    form.submit();
} 


function crea_form(url, metodo, target,params) {
    var forma = document.createElement('form');
    forma.setAttribute('name', 'myForm');
    forma.setAttribute('id', 'myForm');
    forma.setAttribute('action',url);
    forma.setAttribute('target',target);
    forma.setAttribute('method',metodo);

    if (params!=''){
        for (var i in params) {
            if (params.hasOwnProperty(i)) {
                var input = document.createElement('input');
                input.type = 'hidden';
                input.name = i;
                input.value = params[i];
                forma.appendChild(input);
            }
        }

    }
    document.body.appendChild(forma);
    forma.submit();
}

function crea_formOpenWindow(url,params) {
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", url);
    // setting form target to a window named 'formresult'
    form.setAttribute("target", "formresult");
    if (params!=''){
        for (var i in params) {
            if (params.hasOwnProperty(i)) {
                var input = document.createElement('input');
                input.type = 'hidden';
                input.name = i;
                input.value = params[i];
                form.appendChild(input);
            }
        }
    }
}

function actualizarGrilla(elemento){
    alert('hola mundo');
    alert(elemento.value());
}