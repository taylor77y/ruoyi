import Cookies from 'js-cookie'

const TokenKey = 'Admin-Token'
const ID = 'Admin-ID'

export function getToken() {
  return Cookies.get(TokenKey)
}

export function setToken(token) {
  return Cookies.set(TokenKey, token)
}

export function removeToken() {
  return Cookies.remove(TokenKey)
}

export function getId() {
  return Cookies.get(ID)
}

export function setId(token) {
  return Cookies.set(ID, token)
}
