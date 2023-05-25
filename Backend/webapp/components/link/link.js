class linkElement extends HTMLElement {
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
            principal: "index.jsp",
            productos: "verProductos",
            categorias: "verCategorias",
            contacta:"contact.jsp",
            sobrenosotros:"about.jsp"
        }
        this.focus = validsLinks[this.name.toLocaleLowerCase()] === location ? "focus" : "";
    }
    connectedCallback() {
        this.focusLink();
        this.shadowRoot.innerHTML = `
        <style>
            @import "./components/link/link.css";
        </style>
        <a class="${this.isVariant} ${this.focus}" href="${this.href}">${this.name}</a>
      `;
    }
};

customElements.define("link-element", linkElement);
