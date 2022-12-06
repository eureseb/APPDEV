type UniversityRowProps = {
    value: string,
    colId: string,
}

export default function UniversityRow(props:UniversityRowProps){
    const schoolLogo = (value: string) => {
        let temp = "";
        if(value == 'Cebu Institute of Technology - University')
            temp = "./Images/CIT_Logo.png";
        else if(value == "University of the Visayas")
            temp = "./Images/UV_Logo.png";
        else if(value == "University of Cebu")
            temp = "./Images/UC_Logo.png";
        else if(value == "University of San Carlos")
            temp = "./Images/USC_Logo.png";
        else if(value == "Southwestern University - PHINMA")
            temp = "./Images/SWU_Logo.png";
        else if(value == "Cebu Technological University")
            temp = "./Images/CTU_Logo.png";
        else if(value == "University of San Jose-Recoletos")
            temp = "./Images/USJR_Logo.png";
        else if(value == "Cebu Eastern College")
            temp = "./Images/CEC_Logo.png";
        else if(value == "Cebu City National Science High School")
            temp = "./Images/CCNHS_Logo.png";
        else if(value == "Velez College")
            temp = "./Images/VELEZ_Logo.png";
        return temp;
    }

    const conditionRow = (value: string) => {
        return(
            <>
                <img src={schoolLogo(value)} style={{ height: "45px", width: "45px"}} />
                <div style={{display:"inline-block", 
                paddingLeft: "10px", 
                verticalAlign:"top", 
                marginTop:"15px"}}>{value}</div>
            </>
        );
    }

    const displayRow = (value: string, colId: string) => {
        if(colId == "name")
      return (
        conditionRow(value)
      );
    else if(colId == "details")
      return( <div style={{maxWidth:230}}>{value}</div> )
    else
      return( value );
    }

    return(
        <>
          {displayRow(props.value, props.colId)}
        </>
    );
}