
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
        <nav>
            <slot/>
            <slot />
            <slot />
            <slot />
            <slot />
            <slot />
        </nav>
      `;

    }
};

customElements.define("nav-element", navElement);
