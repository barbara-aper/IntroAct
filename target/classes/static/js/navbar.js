const navBarBtn = document.querySelectorAll('ul#navbar-buttons a');
const pathname = window.location.pathname;

console.log(pathname);

if(pathname == '/index' || pathname == '/') navBarBtn[0].style.setProperty('color', '#f07e24', 'important');
if(pathname == '/atividades') navBarBtn[1].style.setProperty('color', '#f07e24', 'important');
if(pathname == '/faq') navBarBtn[2].style.setProperty('color', '#f07e24', 'important');
if(pathname == '/contato') navBarBtn[3].style.setProperty('color', '#f07e24', 'important');