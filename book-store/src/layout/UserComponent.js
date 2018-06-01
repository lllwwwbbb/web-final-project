import React from 'react';
import {Button, Dropdown, Icon, Menu} from "antd";
import './UserComponent.css'
const MenuItem = Menu.Item;

export class UserComponent extends React.Component {

    state = {
        hasLogin: false,
    };

    menu = (onLogout) => (
        <Menu>
            <MenuItem>
                <a onClick={onLogout}>Logout</a>
            </MenuItem>
        </Menu>
    );

    render() {
        const {userName, onLogout} = this.props;
        return (
            <div className="user-menu">
                <Dropdown style={{maxHeight: '30px'}}
                    overlay={this.menu(onLogout)}
                >
                    <div>
                        {userName}
                        <Icon type="down"/>
                    </div>
                </Dropdown>
            </div>
        )
    }
}