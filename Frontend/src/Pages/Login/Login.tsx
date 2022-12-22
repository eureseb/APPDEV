import { Box } from "@mui/material";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import CSS from 'csstype';
import LoginPaper from "../../Components/Papers/LoginPaper";

const mdTheme = createTheme();



const center: CSS.Properties = {
    marginLeft: "auto",
    marginRight:"auto",
    textAlign: "center",
    display:"block",
    justifyContent:"center",
    verticalAlign: "middle",
    margin:"auto"
}


export default function Login(){
    return(
        <ThemeProvider theme={mdTheme}>
            <Box component="main"
          sx={{
            backgroundColor: "#363740",
            flexGrow: 1,
            height: '100vh',
          }}>
                <div style={{
                        position: 'absolute', left: '50%', top: '50%',
                        transform: 'translate(-50%, -50%)'
                    }}
                    >
                    <LoginPaper/>
                </div>
            </Box>
        </ThemeProvider>
    );
}