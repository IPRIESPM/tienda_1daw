
class FooterElement extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({ mode: "open" });
    }

    connectedCallback() {
        this.shadowRoot.innerHTML = `
        <style>
            @import "./components/footer/footer.css";
        </style>
        <footer>
            <section>
                <slot name="1"></slot>
                <slot name="2"></slot>
                <slot name="3"></slot>
            </section>

            <section>
                <slot name="4"></slot>
                <slot name="5"></slot>
                <slot name="6"></slot>
            </section>

            <section>
                <slot name="7"></slot>
                <slot name="8"></slot>
                <slot name="9"></slot>
            </section>
        </footer>
      `;
    }
};

customElements.define("footer-element", FooterElement);
