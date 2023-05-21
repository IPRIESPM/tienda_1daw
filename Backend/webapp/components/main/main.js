
class MainElement extends HTMLElement {
    setBackground(bg){
        let background = bg != null | bg != "sheet" ? bg : "sheet"
        return background;
    }

    constructor() {
        super();
        this.attachShadow({ mode: "open" });
        this.sheet = this.setBackground(this.getAttribute("sheet"));
    }

    connectedCallback() {
        this.shadowRoot.innerHTML = `
        <style>
            @import "./components/main/main.css";
        </style>
        <main class=${this.seet}>
            <slot></slot>
        </main>
      `;

    }
};

customElements.define("main-element", MainElement);
