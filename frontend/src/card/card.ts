export function showArticleCard (): void {
  const cards = document.querySelectorAll('div.card-inner')
  const showHideButton = document.querySelectorAll('div.showHideButton')
  const modalDiv = document.querySelector('div.card-modal') as HTMLDivElement

  showHideButton[1].addEventListener('click', () => {
    modalDiv.classList.add('ux-hidden')
    modalDiv.classList.remove('ux-show')
  })

  cards.forEach(card => {
    card.addEventListener('click', () => {
      console.log('click')
      modalDiv.classList.remove('ux-hidden')
      modalDiv.classList.add('ux-show')
    })
  })
}
