import React from 'react'
import { Modal } from 'semantic-ui-react'
import { Button } from 'semantic-ui-react'
export default function InfoModal(props) {
    return (
        <Modal
        
        
        header='Reminder!'
        content='Call Benjamin regarding the reports.'
        actions={['Snooze', { key: 'done', content: 'Done', positive: true }]}

      />
    )
}
