function studioDeselection() {
  for (const element of document.getElementsByName('studio')) {
    element.checked = false;
  }
}

function weekDeselection() {
  for (const element of document.getElementsByName('week')) {
    element.checked = false;
  }
}
