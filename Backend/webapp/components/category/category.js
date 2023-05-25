
class CategoryElement extends HTMLElement {

    autoColor(color){
        if(color === "auto"){

            const colorList = ['pink','blue','green'];
            const aleatory = Math.floor(Math.random() * (3 - 0));
            console.log(aleatory)
            console.log(colorList[aleatory])
            return colorList[aleatory];
        }
    }

    sendRedirect() {
        location.href = this.href;

    }

    constructor() {
        super();
        this.attachShadow({ mode: "open" });
        this.color = this.getAttribute("color") == null ? "auto" : this.getAttribute("color");
        this.href = this.getAttribute("href") !== null ? this.getAttribute("href") : "";
    }

    connectedCallback() {
        this.shadowRoot.innerHTML = `
        <style>
            @import "./components/category/category.css";
        </style>
        <section class=" ${this.autoColor(this.color)}">
            <slot></slot>
        </section>
      `;

        this.button = this.shadowRoot.querySelector("section");
        this.button.addEventListener("click", this.sendRedirect.bind(this));
    }
};

customElements.define("category-element", CategoryElement);
