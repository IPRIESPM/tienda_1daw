
class ButtonElement extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({ mode: "open" });
        this.data = this.getAttribute("data") !== null ? this.getAttribute("data") : "Carrito";
        this.href = this.getAttribute("href") !== null ? this.getAttribute("href") : "./carrito?carrito=ver";
        this.type = this.getAttribute("type") !== null ? this.getAttribute("type") : "button";
    }
    sendRedirect() {
        location.href = this.href;
    }

    connectedCallback() {
        this.shadowRoot.innerHTML = `
        <style>
            @import "./components/button/button.css";
        </style>
        <input class="button" type="${this.type}" value="${this.data}" title="${this.href}">
      `;
        if (this.type === "button") {
            this.button = this.shadowRoot.querySelector("input");
            this.button.addEventListener("click", this.sendRedirect.bind(this));
        }
    }
};

customElements.define("button-element", ButtonElement);
