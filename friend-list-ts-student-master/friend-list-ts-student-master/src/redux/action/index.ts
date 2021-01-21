export const openModal = (typeModal: string) => ({
  type: 'OPEN_MODAL',
  typeModal
})

export const closeModal = () => ({
  type: 'CLOSE_MODAL',
})

export const openModalEdit = (typeModal: string, friendID: number) => ({
  type: 'OPEN_MODAL',
  typeModal,
  friendID,
})

export const addFriend = (name: string, address: string, phoneNumber: string) => ({
  type: 'ADD_FRIENDS',
  name,
  address,
  phoneNumber
})

export const editFriend = (id: number, name: string, address: string, phoneNumber: string) => ({
  type: 'EDIT_FRIENDS',
  id,
  name,
  address,
  phoneNumber
})

export const deleteFriend = (id: number) => ({
  type: 'DELETE_FRIENDS',
  id,
})