
class CardElement extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({ mode: "open" });
    }

    connectedCallback() {
        this.shadowRoot.innerHTML = `
        <style>
            @import "./components/card/card.css";
        </style>

        <section>
            <slot name="card-head"></slot>
            <slot name="card-body"></slot>
        </section>
      `;

    }
};

customElements.define("card-element", CardElement);
