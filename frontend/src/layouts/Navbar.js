import React from 'react'
import { Button, Dropdown, Menu } from 'semantic-ui-react'

export default function Navbar() {
    return (
        <Menu inverted fixed="top" size='large'>
        <Menu.Item
          name='home'
         
        />
        <Menu.Item
          name='messages'
          
        />

        <Menu.Menu position='right'>
          <Dropdown item text='Menu'>
            <Dropdown.Menu>
              <Dropdown.Item>Sayfa-1</Dropdown.Item>
            </Dropdown.Menu>
          </Dropdown>

          <Menu.Item>
            <Button primary>Giriş Yap</Button>
          </Menu.Item>
        </Menu.Menu>
      </Menu>
    )
}
