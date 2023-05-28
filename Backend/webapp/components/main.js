import "./button/button.js";
import "./link/link.js";
import "./input/input.js";
import "./nav/nav.js";
import "./footer/footer.js";
import "./category/category.js";
import "./card/card.js";
import "./product/product.js";
import "./main/main.js";
import "./drop/drop.js";




const konamiCode = [
    "ArrowUp","ArrowUp",
    "ArrowDown","ArrowDown",
    "ArrowLeft","ArrowRight",
    "ArrowLeft","ArrowRight",
    "b","a"
];

let konamiCodePosition = 0;
document.addEventListener("keydown", function(event) {
  const key = event.key;
  if (key === konamiCode[konamiCodePosition]) {
    console.log("Secreto encontrado con: "+key);
    konamiCodePosition++;
    if (konamiCodePosition === konamiCode.length) {
        console.log("¡Código Konami detectado!");
        const audio = document.createElement("audio");
        audio.src="/tiendaDaw/assets/audio/slime.mp3";
        audio.volume = 0.3;
        audio.play();
        konamiCodePosition = 0;
    }
  } else {
    console.log("¡Secreto perdido 😥!");
    konamiCodePosition = 0;
  }
});
