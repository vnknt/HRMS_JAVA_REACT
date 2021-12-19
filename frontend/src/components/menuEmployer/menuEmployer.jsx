import React from 'react'
import { Link } from 'react-router-dom'
export default function menuEmployer() {
    return (
        <ul class="list-group ">
            <Link to="/add-job-advert" class="list-group-item active" aria-current="true">İlan Yayınla</Link>
            <Link to="/applies" class="list-group-item">Başvurular</Link>
            <Link to="/messages" class="list-group-item">Mesajlar</Link>

        </ul>
    )
}
