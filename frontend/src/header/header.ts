export function showHiddenHamburger (): void {
  const hamburgerDiv = document.querySelector('div.hamburger') as HTMLDivElement
  const ulMenuNav = document.querySelector('ul.top-nav-inner') as HTMLUListElement

  hamburgerDiv.addEventListener('click', () => {
    let action
    let icon
    if (ulMenuNav.style.display === 'none') {
      action = 'flex'
      icon = '<i class="bi bi-x-lg"></i>'
    } else {
      action = 'none'
      icon = '<i class="bi bi-list"></i>'
    }
    ulMenuNav.style.display = action
    hamburgerDiv.innerHTML = icon
    console.log(action)
  })
}

export function loggingUser (): void {
  const loggingForm = document.querySelector('form#form-logging') as HTMLFormElement
  const logginLogged = document.querySelector('div.logged') as HTMLDivElement
  loggingForm.addEventListener('submit', (event) => {
    event.preventDefault()

    const userUser = document.querySelector('#email') as HTMLInputElement
    const userPassword = document.querySelector('#email') as HTMLInputElement
    if (userUser.value === 'usuario' && userPassword.value === 'usuario') {
      logginLogged.classList.add('ux-show')
      loggingForm.classList.add('ux-hidden')
    }
  })
}
