import { Diversity1 } from "@mui/icons-material";
import { Container, Grid, Paper, styled } from "@mui/material";
import CSS from 'csstype';
import { useContext, useEffect, useState } from "react";
import { useRestUniversity } from "../../Services/useREST";
import AddDialog from "../Dialog/AddDialog";
import { AddContext } from "../Helpers/AddContext";
import { RestContext } from "../Helpers/RestContext";
import { ErrorDivStyling, SuccessDivStyling } from "./RemoveUniversity";

type DivProps = {
    message: string,
    fontSize: string,
}

type FormProps = {
    title1: string,
    title2: string
}

const FontStyling: CSS.Properties = {
    fontFamily: "Mulish",  
    float:"left",
    fontSize: "16.5px",
    paddingTop:"5px"
}

const InputStyling: CSS.Properties = {
    fontFamily: "Mulish",  
    float:"left",
    marginTop:"5px",
    fontWeight:"bold",
    fontSize: "18px",
    borderRadius:"8px",
    border: "1px solid #ccc",
    background: "transparent",
    outline:"none",
    height: "42px",
    width:"316px",
    padding:"5px"
}

const ButtonStyling: CSS.Properties = {
    fontFamily: "Mulish",  
    marginTop:"25px",
    fontSize: "15px",
    borderRadius:"5px",
    color:"white",
    border: "1px solid transparent",
    background: "#3751FF",
    outline:"none",
    height: "42px",
    width:"316px",
    padding:"5px",
    marginLeft:"auto",
    marginRight:"auto",
    cursor:"pointer",
}

function FormInput(props:FormProps){
    const [name,setName] = useState("");
    const [details,setDetails] = useState("");
    const [isEmpty,setIsEmpty] = useState(false);
    const [render,setRender] = useState(false);
    const rest = useContext(RestContext);
    const addCon = useContext(AddContext);

    const addDialog = () =>{
        if(addCon?.openDialog) return( <AddDialog name={name} details={details}/> ); 
    }

    useEffect(()=>{
        const interval = setInterval(() => {
            setRender(false)
            }, 2000);
        return () =>{
            setRender(true)
            clearInterval(interval);
        } 
    },[addCon?.renderer])

    const divErrorMessage = () => {
        if(render){
            if(isEmpty){
                if(name.length < 1 && details.length < 1) 
                    return( <div style={ErrorDivStyling}> Input cannot be empty </div> );
                else if(name.length < 1)
                    return( <div style={ErrorDivStyling}> Name cannot be empty </div> );
                else
                    return( <div style={ErrorDivStyling}> Details cannot be empty </div> );
            }  
            else if(rest?.success)
                return( <div style={SuccessDivStyling}> {rest?.post} </div> );
            return( <div style={ErrorDivStyling}> {rest?.post} </div> );        
        }
    }

    const btnOnClick = () =>{
        if(name != "" && details != "")
            { addCon?.setOpenDialog(true); setIsEmpty(false); } 
        else
            { setIsEmpty(true); addCon?.setRenderer(!addCon?.renderer) }       
    }

    const handleChangeName = (event: React.ChangeEvent<HTMLInputElement>) => {
        setName(event.target.value + "");
    }

    const handleChangeDetails = (event: React.ChangeEvent<HTMLInputElement>) => {
        setDetails(event.target.value + "");
    }
    
    return(
        <Grid container spacing={0} sx={{paddingTop:"5px"}}>
            <Grid item xs={12}>
                <div style={FontStyling}>{props.title1}</div>
            </Grid>
            <Grid item xs={12}>
                <input style={InputStyling} type="text" onChange={handleChangeName}></input>
            </Grid>
            <Grid item xs={12}>
                <div style={FontStyling}>{props.title2}</div>
            </Grid>
            <Grid item xs={12}>
                <input style={InputStyling} type="text" onChange={handleChangeDetails}></input>
            </Grid>
            <Grid item xs={12}>
                <button style={ButtonStyling} onClick={btnOnClick}>Create/Add university</button>
            </Grid>
            <Grid item xs={12}>
                {divErrorMessage()}
            </Grid>
                {addDialog()}
        </Grid>
    );
}

function HeaderDiv(props:DivProps){
    const FontStyling: CSS.Properties = {
        fontFamily: "Mulish", 
        fontWeight: "bold", 
        float:"left",
        fontSize: props.fontSize+"", 
    }
    return(
        <div style={FontStyling}>{props.message}</div>
    );
}

function DescriptionDiv(props:DivProps){
    const FontStyling: CSS.Properties = {
        fontFamily: "Mulish", 
        float:"left",
        fontSize: props.fontSize+"",
        color: "#808080",
        margin:"0px",
        width:"300px",
        paddingTop:"5px",
        textAlign:"left",
    }
    return(  
        <div style={FontStyling}>{props.message}</div>
    );
}

export default function AddUniversity(){
    return(
        <Paper
            sx={{
            p: 2,
            flexDirection: 'column',
            height: 584,
            position:"relative"
            }}
        >
            {/*<img src="./Images/confetti2.png" style={{
                    position:"absolute",
                    transform: "scale(0.9)",
                    left:"63%",
                    bottom:"60%"
                   }} />*/}
            <div style={{padding: "20px", position:"relative"}}>
                <Grid container spacing={0}>
                    <Grid item xs={12}>
                        <HeaderDiv message={"Add University"} fontSize={"20px"}/>
                    </Grid>
                    <Grid item xs={12}>
                        <DescriptionDiv message={"Creates/Adds a unviersity entry into the database."} fontSize={"15px"}/> 
                    </Grid>
                </Grid>
        
                <FormInput title1={"University Name"} title2={"University Details"}/>
                <img src="./Images/student_cartoon3.png" style={{
                    position:"absolute",
                    transform: "scale(0.5)",
                    left:"40%",
                    top:"90%"
                   }} />
            </div>
        </Paper>
    );
}