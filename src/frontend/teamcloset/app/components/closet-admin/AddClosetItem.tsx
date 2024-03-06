'use client';

export default function AddClosetItem() {

    const handleSubmit = (event: any) => {
        event.preventDefault();
        console.log(`button "smashed"`);
    }

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
            <h1>Add an item</h1>
            <div>
                <h2 className="grid justify-items-center">Model:</h2>
                <input className="bg-rose-50 rounded-md" type="text" id="model" required minLength={2} maxLength={70} />
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
                <input className="bg-rose-50 rounded-md" type="number" min="0.00" max="10000.00" step="0.01" id="price" defaultValue="0" />
            </div>
            <div>
                <h2 className="grid justify-items-center">Quantity:</h2>
                <input className="bg-rose-50 rounded-md" type="number" min="0" max="100" step="1" id="quantity" defaultValue="1" />
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