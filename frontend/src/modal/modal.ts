export function showHiddenModal (): void {
  const showHiddenButton = document.querySelector('.showHideButton') as HTMLDivElement
  const modalDiv = document.querySelector('.modal') as HTMLDivElement
  const registerButton = document.querySelector('#register') as HTMLButtonElement

  //   const submitButton = modalDiv.querySelector('input[type=submit]') as HTMLInputElement
  const inputs = modalDiv.querySelectorAll('input') as NodeList

  for (let index = 0; index < inputs.length; index++) {
    const input = inputs[index] as HTMLInputElement
    if (input.type === 'submit' || input.type === 'button') {
      const input = inputs[index] as HTMLInputElement
      input.addEventListener('click', (event) => {
        event.preventDefault()
        modalDiv.classList.remove('ux-show')
        modalDiv.classList.add('ux-hidden')
      })
    }
  }

  registerButton.addEventListener('click', () => {
    modalDiv.classList.remove('ux-hidden')
    modalDiv.classList.add('ux-show')
  })

  showHiddenButton.addEventListener('click', () => {
    modalDiv.classList.remove('ux-show')
    modalDiv.classList.add('ux-hidden')
  })
}
