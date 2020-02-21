// const width = window.screen.width; //
// const height = window.screen.height;

// function getAutoWidth(wid){
//     return wid*width/375 + "px";
// }

var docEl = document.documentElement,
    resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
    recalc = function() {
        if (docEl.clientWidth < 640 && docEl.clientWidth > 320) {
            docEl.style.fontSize = 32 * (docEl.clientWidth / 320) + 'px';
        } else if (docEl.clientWidth >= 640) {
            docEl.style.fontSize = '64px';
        } else if (docEl.clientWidth <= 320) {
            docEl.style.fontSize = '32px';
            
        }
    };
window.addEventListener(resizeEvt, recalc, false);
document.addEventListener('DOMContentLoaded', recalc, false)