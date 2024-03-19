'use client'

import {useState, useEffect} from 'react';

interface ClosetItem {
    id: number,
    model: String,
    series: String,
    size: String,
    gender: String,
    season: String,
    bodyPart: String,
    price: Number,
    quantity: Number
}


export default function DisplayTeamCloset() {

    const webUrl = "http://localhost:8080";

    const [closetItems, setClosetItems] = useState<ClosetItem[]>([]); 

    useEffect(function() {
        const getClosetItems = async() => {

            await fetch(webUrl + "/closet/getclosetitems")
            .then(response => response.json())
            .then(data => {
                console.log(data);
                setClosetItems(data);
            })
        }
    getClosetItems();

    })


    return (
        <div>
        <p>This is the team closet, showing all available items</p>
        <div>
        <h1>Closet Items</h1>
            <ul>
                {closetItems.map((item) => (
                    <li key={item.id}>
                        Model: {item.model}, Series: {item.series}, Size: {item.size}, Gender: {item.gender}, Season: {item.season}, 
                        Body Part: {item.bodyPart}, Price: {item.price.toString()}, Quantity: {item.quantity.toString()}
                    </li>
                ))}
            </ul>
        </div>
        </div>
    )
}