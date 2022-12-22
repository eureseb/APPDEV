import axios, { AxiosRequestConfig } from "axios";
import { createContext, useEffect, useState } from "react";

export interface IUniversity{
    id:string,
    name:string,
    details:string,
    dateAdded:string,
    lastUpdated:string,
    hours:string
}

interface IStatistics{
    courseCount:number,
    studentCount:number,
    teacherCount:number,
    universityCount:number
}

interface RestContextDoer {
    getStatistics:(config: AxiosRequestConfig<any>)=>void, 
    putUniversity: (iuser: IUniversity)=>void,
    sendRequestUni:(config: AxiosRequestConfig<any>)=>void, 
    deleteUniversity: (id: string)=> void, 
    postUniversity: (iuser: IUniversity)=> void, 
    setRenderer:React.Dispatch<React.SetStateAction<boolean>>,
    deleted: string,
    uniData: IUniversity[] | undefined, 
    error: string, 
    loading: boolean, 
    success: boolean,
    renderer: boolean,
    post: string, 
    put:string,
    statistics: IStatistics | undefined
}

export const RestContext = createContext<RestContextDoer | null>(null);

export default function RestContextProvider(props:{children:React.ReactNode}){
    const [uniData,setUniData] = useState<IUniversity[]>();
    const [statistics,setStatistics] = useState<IStatistics>();
    const [renderer,setRenderer] = useState(false);
    const [success,setSuccess] = useState(false);
    const [loading, setLoading] = useState(false);
    const [put,setPut] = useState("");
    const [error, setError] = useState("");
    const [deleted,setDeleted] = useState("");
    const [post,setPost] = useState("");

    function sendRequestUni(config: AxiosRequestConfig<any>){
        setLoading(true)
        axios(config)
        .then((response) => {
            setError('');
            setUniData(response.data);
        })
        .catch((error) => {
            setError(error.message);
        })
        .finally(()=>setLoading(false))
    }

    function deleteUniversity(id:string){
        setLoading(true);
        axios.delete("http://localhost:8080/university/"+id)
        .then((response)=>{
            setDeleted(response.data)
            if(response.data == "University ID Number " + id + " is not found!")
                setSuccess(false)
            else
                setSuccess(true)         
        })
        .catch((error)=>{
            setError(error.message);
            setSuccess(false)
        })
        .finally(()=>{
            setLoading(false)
        })
      
    }

    function postUniversity(iuser:IUniversity){
        setLoading(true);
        axios.post("http://localhost:8080/university",{
            name:iuser.name,
            details:iuser.details
        }
        )
        .then((response)=>{
           setPost("A new university has been added");
           setSuccess(true)
        })
        .catch((error)=>{
            setPost("Failed to add new university")
            setError(error.message);
            setSuccess(false)
        })
        .finally(()=>{
            setLoading(false)
        })
    }

    function putUniversity(iuser:IUniversity){
        setLoading(true);
        axios.put("http://localhost:8080/university?id="+iuser.id,{
            name:iuser.name,
            details:iuser.details
        }
        )
        .then((response)=>{
           setPut("Successfully updated University ID: "+iuser.id)
           setSuccess(true)
        })
        .catch((error)=>{
            setPut("University ID: "+iuser.id+" does not exist")
            setError(error.message);
            setSuccess(false)
        })
        .finally(()=>{
            setLoading(false)
        })
    }

    function getStatistics(config: AxiosRequestConfig<any>){
        setLoading(true)
        axios(config)
        .then((response) => {
            setError('');
            setStatistics(response.data);
        })
        .catch((error) => {
            setError(error.message);
        })
        .finally(()=>setLoading(false))
    }
    
    return(
        <RestContext.Provider value={{getStatistics, putUniversity,sendRequestUni,deleteUniversity,
            postUniversity,setRenderer,deleted,uniData,error,loading,success,renderer,post,put,
            statistics}}>
            {props.children}
        </RestContext.Provider>  
    );
}