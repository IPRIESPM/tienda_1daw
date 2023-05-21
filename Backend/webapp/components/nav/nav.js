
class navElement extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({ mode: "open" });
    }

    connectedCallback() {
        this.shadowRoot.innerHTML = `
        <style>
            @import "./components/nav/nav.css";
        </style>
        <header>
            <nav>
                <i class="bi bi-list hidden"></i>
                <slot> </slot>
                <slot> </slot>
                <slot> </slot>
                <slot> </slot>
                <slot> </slot>
                <slot> </slot>
            </nav>
        </header>
      `;

    }
};

customElements.define("nav-element", navElement);
