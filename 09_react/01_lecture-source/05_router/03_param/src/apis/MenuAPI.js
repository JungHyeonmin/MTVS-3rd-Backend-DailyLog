import menus from '../data/menu-detail.json';

export function getMenuList() {

    return menus;
}

export function getMenuDetail(menuCode) {

    return menus.filter(menu => menu.menuCode === parseInt(menuCode))[0];
}

export function searchMenu(searchMenuName) {
    return menus.filter(menu => menu.menuName.match(searchMenuName));
}