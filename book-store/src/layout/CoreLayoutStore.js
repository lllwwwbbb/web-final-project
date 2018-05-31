import {BookListComponent} from "../book/BookListComponent";
import React from "react";

export const TabObj = {
    activeKey: 'store',
    panes: [{
        key: 'store',
        title: '图书列表',
        content: <BookListComponent/>,
    }]
};

export const removeTab = (targetKey) => {
    console.log('remove tab', targetKey);
};

export const addTab = (key, title, content) => {
    TabObj.panes.push({key, title, content});
    TabObj.activeKey = key;
};

export const switchTab = (targetKey) => {
    TabObj.activeKey = targetKey;
};