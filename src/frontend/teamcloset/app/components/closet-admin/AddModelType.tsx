'use client';

export default function AddModelType() {
    
    const webUrl = "http://localhost:8080";

    const handleSubmit = async (event: any) => {
        event.preventDefault();

        const data = {
            modelName: String(event.target.modelName.value)
        }

        console.log(JSON.stringify(data));

        await fetch (webUrl + "/admin/addmodel", {
            method: 'POST',
            headers: { 
            "Content-Type": "application/json" 
            },
            body: JSON.stringify(data),
        }).then((response) => response.json()).then(data => {
            console.log("backend data: " + JSON.stringify(data));
        })
    };

    
    
    return(
        <div className="flex justify-left">
        <form onSubmit={handleSubmit} className="grid justify-items-center">
            <h1 className = "text-base">Add a new model here!</h1>
            <div>
                <h2 className="grid justify-items-center text-sm">Model name:</h2>
                <input className="bg-rose-50 rounded-md" type="text" id="modelName" required minLength={4} maxLength={100} />
            </div>
            <br></br>
            <button className="bg-rose-50 p-20 hover:bg-rose-100 rounded-full" type="submit">Add!</button>
        </form>
        </div>
            )

}