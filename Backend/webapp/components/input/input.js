
class inputElement extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({ mode: "open" });
        this.type = this.getAttribute("type") !== null ? this.getAttribute("type") :"text";
        this.name = this.getAttribute("name") !== null ? this.getAttribute("name") :"";
        this.place = this.getAttribute("place") !== null ? this.getAttribute("place") :"";
    }

    connectedCallback() {
        this.shadowRoot.innerHTML = `
        <style>
            @import "./components/input/input.css";
        </style>
        <fieldset class="inputComponent">
            <input class="inputComponent" type="${this.type}" name="${this.name}" placeholder="${this.place}">
            <img class="inputComponent" src="/tiendaDaw/assets/img/pink.png" />
        </fieldset>
      `;
    }
};

customElements.define("input-element", inputElement);
