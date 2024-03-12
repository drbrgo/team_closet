import AddClosetItem from "../components/closet-admin/AddClosetItem"
import AddModelType from "../components/closet-admin/AddModelType"

export default function adminRoot() {
    return (
        <div className = "flex items-start space-x-80">
        <p>this is the admin root</p>
        <AddClosetItem />
        </div>
    )
}