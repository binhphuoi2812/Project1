type Action = {
  type: string,
  typeModal: string,
  friendID: number,
}

export const ModalFriend = (state = {isActive: false, typeModal: '', friendID: 0}, action: Action)  => {
  switch (action.type) {
    case 'OPEN_MODAL': 
      return state = {
        isActive: true,
        typeModal: action.typeModal,
        friendID: action.friendID,
      }
    case 'CLOSE_MODAL': 
      return state = {
        isActive: false,
        typeModal: '',
        friendID: action.friendID,
      }
    default:
      return state
  }
}