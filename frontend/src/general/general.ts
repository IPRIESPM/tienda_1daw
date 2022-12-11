
export function deactivatedLinks (): void {
  const links = document.querySelectorAll('a')
  links.forEach(link => {
    const deactivated = link.classList.contains('ux-deactivated')
    if (deactivated) {
      link.addEventListener('click', (event) => {
        event.preventDefault()
      })
    }
  })
}
