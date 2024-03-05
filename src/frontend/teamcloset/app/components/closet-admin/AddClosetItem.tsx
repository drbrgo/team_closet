'use client';

export default function AddClosetItem() {

    const handleSubmit = (event: any) => {
        event.preventDefault();
        console.log(`button "smashed"`);
    }
    
    return(
        <div>
        <p>add an item form will go here</p>
        <form onSubmit={handleSubmit}>
            <h1>Add an item</h1>
            <div>
                <h2>Model:</h2>
                <input className="bg-rose-50" type="text" id="model" required minLength={2} maxLength={70} />
            </div>

            <button className="bg-rose-50 p-20 hover:bg-rose-100 rounded-full" type="submit">Add!</button>
        </form>
        </div>
    )
}