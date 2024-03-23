'use client'

import {useState, useEffect} from 'react';
import ClosetItemCard from './ClosetItemCard';

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

    const [sizeFilter, setSizeFilter] = useState("");

    useEffect(function() {
        const getClosetItems = async() => {

            await fetch(webUrl + "/closet/getclosetitems" + (sizeFilter ? `?param=${sizeFilter}` : ""))
            .then(response => response.json())
            .then(data => {
                console.log(data);
                setClosetItems(data);
            })
        }
    getClosetItems();

    }, [sizeFilter]); //calls useEffect whenever filter changes

    const allItems = closetItems.map((item: any) => {
        return (
            <ClosetItemCard
            key={item.id}
            item={item}
            />
        )
    })

    const handleSizeFilter = (event: React.ChangeEvent<HTMLSelectElement>) => {
        setSizeFilter(event.target.value);
    };


    return (
        <div>
        <p>This is the team closet, showing all available items</p>
        <div className="border-2 p-2 m-2">
            <p>this is the size filter</p>
            <select value={sizeFilter} onChange={handleSizeFilter}>
                <option value="">Select size</option>
                <option value="xxs">XXSmall</option>
                <option value="xs">XSmall</option>
                <option value="s">Small</option>
                <option value="m">Medium</option>
                <option value="l">Large</option>
                <option value="xl">XLarge</option>
                <option value="xxl">XXLarge</option>
            </select>
        </div>
        <div className='grid lg: grid-cols-5 md: grid-cols-3'>
        {/* <h1>Closet Items</h1>
            <ul>
                {closetItems.map((item) => (
                    <li key={item.id}>
                        Model: {item.model}, Series: {item.series}, Size: {item.size}, Gender: {item.gender}, Season: {item.season}, 
                        Body Part: {item.bodyPart}, Price: {item.price.toString()}, Quantity: {item.quantity.toString()}
                    </li>
                ))}
            </ul>
        </div> */}
        {allItems}
        <div>
            {/* <p>{closetItems}</p> */}
        </div>
        </div>
        </div>
    )
}