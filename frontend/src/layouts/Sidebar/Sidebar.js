import React from 'react'
import { Icon, Input, Label, Menu } from 'semantic-ui-react'

export default function Sidebar() {
    return (
      <Menu vertical>
      <Menu.Item>
        <Label color='teal'>1</Label>
        Menu
      </Menu.Item>

      <Menu.Item>
        <Label>51</Label>
        Spam
      </Menu.Item>

      <Menu.Item>
        <Label>1</Label>
        Updates
      </Menu.Item>
      
    </Menu>
    )
}
