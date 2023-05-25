class dropElement extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({ mode: "open" });
        this.href = this.getAttribute("href") || null ? this.getAttribute("href") : "index.jsp";
        this.name = this.getAttribute("name") || null ? this.getAttribute("name") : "principal";
        this.isVariant = this.getAttribute("isVariant") == "" ? "variant" : "";
        this.focus = "";
    }
    focusLink(){
        const {pathname} = window.location;
        const [_,location] = pathname.split("/tiendaDaw/");
        const validsLinks = {
            factura: "verFactura",
            pedido: "verPedido",
        }
        this.focus = validsLinks[this.name.toLocaleLowerCase()] === location ? "focus" : "";
    }

    connectedCallback() {
        this.focusLink();
        this.shadowRoot.innerHTML = /*html*/ `
        <style>
            @import "./components/drop/drop.css";
        </style>
        <a class="${this.focus}">${this.name}</a>
        <section class="drop">
            <slot name="1"></slot>
            <slot name="2"></slot>
        </section>
      `;
      this.shadowRoot.querySelector("a").addEventListener("click",()=>{
        this.shadowRoot.querySelector("section.drop").classList.toggle("show");
      });

      document.querySelector("main-element").addEventListener("click",()=>{
        const drop = this.shadowRoot.querySelector("section.drop");
        if(drop.classList.contains("show")) drop.classList.remove("show");
      });
    }
};

customElements.define("drop-element", dropElement);
