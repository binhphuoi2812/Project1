import React from 'react'

import iconUserPlus from 'assets/icons/icon-user-plus.svg';
import iconEdit from 'assets/icons/icon-edit.svg';
import iconPeople from 'assets/icons/icon-people.svg';
import iconTrash from 'assets/icons/icon-trash.svg';
import iconClose from 'assets/icons/icon-close.svg';
import iconPhone from 'assets/icons/icon-phone.svg';
import iconAddress from 'assets/icons/icon-home.svg';
import iconUser from 'assets/icons/icon-user.svg';
import iconFaceSad from 'assets/icons/icon-face-sad.svg';

interface IconType {
  className?: string
  onClick?: Function
  white?: boolean
}
export const FaceSadIcon = ({ className }: IconType): React.ReactElement => (
  <img src={iconFaceSad} className={className} alt="" />
);
export const UserIcon = ({ className }: IconType): React.ReactElement => (
  <img src={iconUser} className={className} alt="" />
);
export const PhoneIcon = ({ className }: IconType): React.ReactElement => (
  <img src={iconPhone} className={className} alt="" />
);
export const AddressIcon = ({ className }: IconType): React.ReactElement => (
  <img src={iconAddress} className={className} alt="" />
);
export const UserPlusIcon = ({ className }: IconType): React.ReactElement => (
  <img src={iconUserPlus} className={className} alt="" />
);
export const PeopleIcon = ({ className }: IconType): React.ReactElement => (
  <img src={iconPeople} className={className} alt="" />
);
export const EditIcon = ({ className }: IconType): React.ReactElement => (
  <img src={iconEdit} className={className} alt="" />
);
export const TrashIcon = ({ className }: IconType): React.ReactElement => (
  <img src={iconTrash} className={className} alt="" />
);
export const CloseIcon = ({ className }: IconType): React.ReactElement => (
  <img src={iconClose} className={className} alt="" />
);
