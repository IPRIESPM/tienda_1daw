
class inputElement extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({ mode: "open" });
        this.href = this.getAttribute("href") !== null ? this.getAttribute("href") :"index.jsp";
        this.data = this.getAttribute("data") !== null ? this.getAttribute("data") :"Principal";
        
    }

    connectedCallback() {
        this.shadowRoot.innerHTML = `
        <style>
            @import "./components/input/input.css";
        </style>
        <fieldset>
            <input type="text" placeholder="test">
            <img src="/tiendaDaw/assets/img/pink.png" />
        </fieldset>
      `;
    }
};

customElements.define("input-element", inputElement);
