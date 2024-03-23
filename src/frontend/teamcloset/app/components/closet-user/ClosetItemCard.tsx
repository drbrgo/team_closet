export default function ClosetItemCard(props: any)  {
return(
    <div className="border-2 p-2 m-2">
        <p>Id: {props.item.id}</p>
        <p>Model: {props.item.model}</p>
        <p>Series: {props.item.series}</p>
        <p>Size: {props.item.size}</p>
        <p>Season: {props.item.season}</p>
        <p>Suggested Price: {props.item.price}</p>
        <p>Quantity: {props.item.quantity}</p>
    </div>
)
}