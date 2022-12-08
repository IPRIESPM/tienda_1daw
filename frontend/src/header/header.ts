export function showHiddenHamburger (): void {
  const hamburgerDiv = document.querySelector('div.hamburger') as HTMLDivElement
  const hamburgerIcon = hamburgerDiv.querySelector('i') as HTMLDialogElement
  const ulMenuNav = document.querySelector('ul.header-ul') as HTMLUListElement

  hamburgerDiv.addEventListener('click', () => {
    let action
    let icon, iconRemove
    if (ulMenuNav.style.display === 'none') {
      action = 'flex'
      icon = 'bi-x-lg'
      iconRemove = 'bi-list'
    } else {
      action = 'none'
      icon = 'bi-list'
      iconRemove = 'bi-x-lg'
    }
    ulMenuNav.style.display = action
    hamburgerIcon.classList.remove(iconRemove)
    hamburgerIcon.classList.add(icon)
    console.log(action)
  })
}

export function loggingUser (): void {
  const loggingForm = document.querySelector('form#formLogging') as HTMLFormElement
  const loggingLogged = document.querySelector('div.logged') as HTMLDivElement
  loggingForm.addEventListener('submit', (event) => {
    event.preventDefault()

    const userUser = document.querySelector('#email') as HTMLInputElement
    const userPassword = document.querySelector('#email') as HTMLInputElement
    if (userUser.value === 'usuario' && userPassword.value === 'usuario') {
      loggingLogged.classList.add('ux-show')
      loggingForm.classList.add('ux-hidden')
    }
  })
}
