'use client';

import { useEffect, useState } from "react";

interface Model {
    id: number,
    modelName: string
}

export default function AddClosetItem(props: any) {

    const [models, setModels] = useState<Model[]>([]);
    const [selectedModel, setSelectedModel] = useState<number | null>(null);
    
    const webUrl = "http://localhost:8080";

    useEffect(() => {
        fetch(webUrl + "/admin/getmodels", {
            method: 'GET',
                    headers: { 
                    "Content-Type": "application/json" 
                    }
        })
      .then(response => response.json())
      .then(data => setModels(data))
      .catch(error => console.error('Error fetching models: ', error));
  }, []);
    

    const handleSubmit = async (event: any) => {
        event.preventDefault();

        const data = {
            model: String(event.target.model.value),
            series: String(event.target.series.value),
            size: String(event.target.size.value),
            gender: String(event.target.gender.value),
            season: String(event.target.season.value),
            bodyPart: String(event.target.bodyPart.value),
            price: Number(event.target.price.value),
            quantity: Number(event.target.quantity.value)
        }
        console.log("front end data: " + JSON.stringify(data));
        // console.log(`button "smashed"`);

        await fetch (webUrl + "/admin/addclosetitem", {
                    method: 'POST',
                    headers: { 
                    "Content-Type": "application/json" 
                    },
                    body: JSON.stringify(data),
                }).then((response) => response.json()).then(data => {
                    console.log("backend data: " + JSON.stringify(data));
                })
            };


        //let's try a different way
    //     try {
    //         const response = await fetch (webUrl + "/admin/addclosetitem/", {
    //         method: "POST",
    //         headers: { 
    //         "Content Type": "application/JSON" 
    //         },
    //         body: JSON.stringify(data),
    //     });

    //     //check for 4 or 5 response code

    //     if (!response.ok) {
    //         throw new Error ("Cannot save new item")
    //     }

    //     if (response.ok) {
    //         console.log("backend data: " + response.body);
    //     }

    //  } catch (error) {
    //     console.log("Caught an error from backend: " + error);
    //     }
    // }

    //shelving model list select element with "create new" option for now. perhaps will be cleaner to 
    //create a "create new model" component, which will then add the new value to the drop down list
    //admittedly slightly less integrated

    // const modelList = document.getElementById("modelList");

    // if (modelList) {
    //     modelList.addEventListener("change", function(event) {
    //         const target = event.target as HTMLSelectElement;
    //         const customInput = document.getElementById("customInput");
    //         const newModel = document.getElementById("newModel");
    //         if (target.value === "addNew" && customInput) {
    //             customInput.style.display = "block";
    //         };
    //     } )
    // };


    // const showInputField = (event: any) => {
    //     const modelList = document.getElementById("modelList");
    //     const customInput = document.getElementById("customInput");
    //     const newModel = document.getElementById("newModel");

    //     if (modelList.value === "addNew") {
    //         customInput.style.display = "block";
    //         newModel.required = true;

    //     } else {
    //         customInput.style.display = "none";
    //     }

    // }
    
    return(
        <div className="flex justify-center">
        <form onSubmit={handleSubmit} className="grid justify-items-center">
            <h1>Add an item here!</h1>
            <div>
                <h2 className="grid justify-items-center">Model:</h2>
                {/* <input className="bg-rose-50 rounded-md" type="text" id="model" required minLength={2} maxLength={70} /> */}
                <select id="model" className="bg-rose-50 rounded-md" value={selectedModel ?? ''} onChange={(e) => setSelectedModel(parseInt(e.target.value))}>
                <option value="" disabled>Select</option>
                {models.map(model => (
                <option key={model.id} value={model.modelName}>{model.modelName}</option>
                ))}
                </select>
            </div>
            <div>
                <h2 className="grid justify-items-center">Series:</h2>
                <select defaultValue="default" id="series" className="bg-rose-50 rounded-md">
                    <option value="default" disabled>Select series</option>
                    <option value="og">OG -- Pink/Yellow/Green/White</option>
                    <option value="2.0">2.0 -- Green/Black/White</option>
                    <option value="3.0">3.0 -- Green Watercolor</option>
                </select>
            </div>
            <div>
                <h2 className="grid justify-items-center">Size:</h2>
                <select defaultValue="default" id="size" className="bg-rose-50 rounded-md">
                    <option value="default" disabled>Select size</option>
                    <option value="xxs">XXS</option>
                    <option value="xs">XS</option>
                    <option value="s">S</option>
                    <option value="m">M</option>
                    <option value="l">L</option>
                    <option value="xl">XL</option>
                    <option value="xxl">XXL</option>
                </select>
            </div>
            <div>
                <h2 className="grid justify-items-center">Gender:</h2>
                <select defaultValue="default" id="gender" className="bg-rose-50 rounded-md">
                    <option value="default" disabled>Select gender</option>
                    <option value="unisex">Unisex</option>
                    <option value="women">Women</option>
                    <option value="men">Men</option>
                </select>
            </div>
            <div>
                <h2 className="grid justify-items-center">Season:</h2>
                <select defaultValue="default" id="season" className="bg-rose-50 rounded-md">
                   <option value="default" disabled>Select season</option>
                   <option value="summer">Summer</option>
                   <option value="transitional">Transitional</option>
                   <option value="winter">Winter</option>
                </select>
            </div>
            <div>
                <h2 className="grid justify-items-center">Body part:</h2>
                <select defaultValue="default" id="bodyPart" className="bg-rose-50 rounded-md">
                    <option value="default" disabled>Select body part</option>
                    <option value="tops">Tops</option>
                    <option value="bottoms">Bottoms</option>
                    <option value="parts">Accessories</option>
                </select>
            </div>
            <div>
                <h2 className="grid justify-items-center">Price:</h2>
                <input className="bg-rose-50 rounded-md" type="number" min="1.00" max="10000.00" step="0.01" id="price" defaultValue="0" />
            </div>
            <div>
                <h2 className="grid justify-items-center">Quantity:</h2>
                <input className="bg-rose-50 rounded-md" type="number" min="1" max="100" step="1" id="quantity" defaultValue="1" />
            </div>
            <br></br>
            {/* <div>
                <h2>Model List:</h2>
                <select id="modelList">
                    <option value ="select">Select Model</option>
                    <option value="placeholder">Placeholder</option>
                    <option value="addNew">Add a new model</option>
                </select>
                <div id="customInput">
                    <input className="bg-rose-50" type="text" id="newModel" />
                </div>
            </div> */}

            <button className="bg-rose-50 p-20 hover:bg-rose-100 rounded-full" type="submit">Add!</button>
        </form>
        </div>
    )
}