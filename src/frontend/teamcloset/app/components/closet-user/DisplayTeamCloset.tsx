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

    const [seriesFilter, setSeriesFilter] = useState("");

    const [genderFilter, setGenderFilter] = useState("");

    const [seasonFilter, setSeasonFilter] = useState("");

    const [bodyPartFilter, setBodyPartFilter] = useState("");

    useEffect(function() {
        const getClosetItems = async() => {

            await fetch(webUrl + "/api/v1/auth/closet/getclosetitems" + "?" + (sizeFilter ? `size=${sizeFilter}` : "") + "&" + (seriesFilter ? `selectSeries=${seriesFilter}` : "") + 
            "&" + (genderFilter ? `gender=${genderFilter}` : "") + "&" + (seasonFilter ? `season=${seasonFilter}` : "") + "&" + (bodyPartFilter ? `bodyPart=${bodyPartFilter}` : ""))
            .then(response => response.json())
            .then(data => {
                console.log(data);
                setClosetItems(data);
            })
        }
    getClosetItems();

    }, [sizeFilter, seriesFilter, genderFilter, seasonFilter, bodyPartFilter]); //calls useEffect whenever filter changes

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

    const handleSeriesFilter = (event: React.ChangeEvent<HTMLSelectElement>) => {
        setSeriesFilter(event.target.value);
    };

    const handleGenderFilter = (event: React.ChangeEvent<HTMLSelectElement>) => {
        setGenderFilter(event.target.value);
    };

    const handleSeasonFilter = (event: React.ChangeEvent<HTMLSelectElement>) => {
        setSeasonFilter(event.target.value);
    };

    const handleBodyPartFilter = (event: React.ChangeEvent<HTMLSelectElement>) => {
        setBodyPartFilter(event.target.value);
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
            <p>this is the series filter</p>
            <select value={seriesFilter} onChange={handleSeriesFilter}>
                <option value="">Select series</option>
                <option value="og">OG -- Pink/Yellow/Green/White</option>
                <option value="2.0">2.0 -- Green/Black/White</option>
                <option value="3.0">3.0 -- Green Watercolor</option>
            </select>
            <p>this is the gender filter</p>
            <select value={genderFilter} onChange={handleGenderFilter}>
                <option value="">Select gender or don't</option>
                <option value="unisex">Unisex</option>
                <option value="women">Women</option>
                <option value="men">Men</option>
            </select>
            <p>this is the season filter</p>
            <select value={seasonFilter} onChange={handleSeasonFilter}>
                <option value="">Select season</option>
                <option value="summer">Summer</option>
                <option value="transitional">Transitional</option>
                <option value="winter">Winter</option>
            </select>
            <p>this is the kit part filter</p>
            <select value={bodyPartFilter} onChange={handleBodyPartFilter}>
                <option value="">Select kit part</option>
                <option value="tops">Tops</option>
                <option value="bottoms">Bottoms</option>
                <option value="parts">Accessories</option>
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