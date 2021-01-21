const InitState = {
    counter: 1,
}
export const counterReducer = (state = InitState , action )=>{
    switch(action.type){
        case 'INCREMENT_COUNT':
            return {
                ...state,
                counter: state.counter + 1
            };
        case 'INCREMENT_SUB':
            return{
                ...state,
                counter:state.counter -1
            }
        default:
            return state;
    }
}

