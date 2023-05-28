
class CardElement extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({ mode: "open" });
    }

    connectedCallback() {
        this.shadowRoot.innerHTML =/*html*/ `
        <style>
            @import "./components/card/card.css";
        </style>

        <section>
            <slot name="card-head"></slot>
            <slot name="card-body"></slot>
            <div class="hidden slime"></div>
        </section>
      `;

    }
};

customElements.define("card-element", CardElement);
