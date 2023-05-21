
class ProductElement extends HTMLElement {

    constructor() {
        super();
        this.attachShadow({ mode: "open" });

        this.path = this.getAttribute("img") || "?";

        this.name = this.getAttribute("name") || "Tu programa ha fallado con exito";

        this.price = this.getAttribute("price") || "99999";

        this.cant = this.getAttribute("cant") || "99999";

        this.id = this.getAttribute("id") || "-9999";

        this.date = this.getAttribute("date") || "23/03/93";

        this.state = this.getAttribute("state") || "Error";

        this.href = this.getAttribute("href") !=null;

        this.type = this.getAttribute("type") == null ? false : this.getAttribute("type");

        this.cart = this.getAttribute("addCart") != null;

        this.result="";

        console.log(this.type);
    }

    selectType() {

        if (this.type == "cart") {
            // Carrito
            this.result = /* html */ `
            <figure>
                <img src="/tiendaDaw/assets/img/plorts/${this.path}">
            </figure>

            <section class="description">
                <h2>${this.name}</h2>
                <p class="price" >${this.price}</p>
            </section>

            <section>
                <p>Cantidad disponible</p>
                <p class="cant">${this.cant}</p>
            </section>

            <section class="input">
                <form action="./carrito" method="get">
                <input type="hidden" name="carrito" value="mod">
                <input type="hidden" name="line"  value="${this.id}">
                    <fieldset class="inputComponent">
                        <input
                            class="inputComponent"
                            type="number"
                            name="value">
                    </fieldset>
                    <input type="submit" value="+" class="button">
                </form>
            </section>`;
            return this.result;
        }

        if (this.type == "order") {
            // Ficha de producto
            this.result = /* html */ `
            <section class="price">
                <p>Pedido nº${this.id}</p>
                <p class="primaryColor">Total: ${this.price}</p>
            </section>

            <section class="state">
                <p>Estado:</p>
                <p class="primaryColor ">${this.state}</p>
            </section>

            <section class="quantity">
                <p>Pedido el:</p>
                <p>${this.date}</p>
                <p class="secondaryColor">${this.cant}u.</p>
            </section>

            <button-element data='Facturar' href='./addInvoice?invoice=${this.id}'></button-element>`;
            return this.result;
        }
        if (this.type == "invoice") {
            // Ficha de producto
            this.result = /* html */ `
            <section class="price">
                <p>Factura nº${this.id}</p>
            </section>

            <section class="state">

            </section>

            <section class="quantity">
                <p>Facturado el:</p>
                <p>${this.date}</p>
            </section>
            <button-element data='XML' href=""></button-element>
            <button-element data='PDF' href=""></button-element>
            `;
            return this.result;
        }

        this.result = /* html */ `
            <figure>
                <img src="assets/img/plorts/${this.path}" alt="" />
            </figure>
            <section class="description">
                <h2>${this.name}</h2>
                <p class="price" >${this.price}</p>
            </section>
            <section>
                <p>Cantidad disponible</p>
                <p class="cant">${this.cant}</p>
            </section>`;
        return this.result;
    }


    addCart() {
        this.result = "";
        if (this.cart && this.type != "order") {
            this.result = /* html */`
            <section>
                <a href="./addCarrito?carrito=add&product=${this.id}">
                    <i class="bi bi-cart-plus"></i>
                </a>
            </section>`
        }

        if (this.link) {
            this.result = /* html */`
            <section>
                <a href="./carrito?carrito=del&line=${this.id}">
                    <i class="bi bi-cart-dash"></i>
                </a>
            </section>`
        }
        return this.result;
    }

    connectedCallback() {
        this.shadowRoot.innerHTML = /* html */ `
        <style>
            @import "./components/product/product.css";
            @import"./components/button/button.css";
            @import "./components/input/input.css";
        </style>
        <section class="product">
            ${this.selectType()}
            ${this.addCart()}
        </section>
      `;
      if(!this.type){
        this.section = this.shadowRoot.querySelector("section");
        this.section.style.cursor="pointer";
        this.section.addEventListener("click", ()=>{
            location.href = `./verProductos?product=${this.id}`;
        });
    }
    }
};

customElements.define("product-element", ProductElement);