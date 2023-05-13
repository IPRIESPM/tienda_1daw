class linkElement extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({ mode: "open" });
        this.href = this.getAttribute("href") !== null ? this.getAttribute("href") :"index.jsp";
        this.name = this.getAttribute("name") !== null ? this.getAttribute("name") :"principal";

    }

    connectedCallback() {
        this.shadowRoot.innerHTML = `
        <style>
            @import "./components/link/link.css";
        </style>
        <a href="${this.href}">${this.name}</a>
      `;
    }
};

customElements.define("link-element", linkElement);
